import javax.swing.*;

public class Viewer extends JFrame {
    Model model;
    JFrame frame;
    JButton addButton;
    JButton removeButton;
    JButton checkButton;
    JButton createButton;
    JLabel label;
    JTextField tf;
    JButton[] branches;
    Controller controller;
    JRadioButton rb;

    public Viewer() {
        controller = new Controller(this);
        model = controller.getModel();
        frame = new JFrame("LAB3");
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        tf = new JTextField();
        checkButton = new JButton("Check");
        createButton = new JButton("Create");
        rb = new JRadioButton("Авто?");
        label = new JLabel("");
        addButton.addActionListener(controller.add);
        removeButton.addActionListener(controller.remove);
        tf.addKeyListener(controller.keyPressed);
        checkButton.addActionListener(controller.check);
        createButton.addActionListener(controller.create);
        frame.add(addButton);
        frame.add(removeButton);
        frame.add(tf);
        frame.add(checkButton);
        frame.add(createButton);
        frame.add(rb);
        frame.add(label);
        rb.setSelected(true);
        addButton.setBounds(0, 0, 100, 100);
        removeButton.setBounds(105, 0, 100, 100);
        tf.setBounds(210, 0, 200, 100);
        checkButton.setBounds(415, 0, 100, 100);
        createButton.setBounds(520, 0, 100, 100);
        rb.setBounds(1800,0,100,50);

        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void branching(int[] array) {
        for (int i = 0; i < branches.length; i++) {
            if (array[i] != 0) {
                branches[i].setText(String.valueOf(array[i]));
            } else {
                branches[i].setText("");
            }
        }
    }

    public void createRoot(int c) {
        int count = (int) Math.pow(2, c) - 1;
        frame.remove(label);
        branches = new JButton[count];
        int x, y, z,megaX;
        z = 1;
        x = 850;
        megaX = 800;
        y = 100;
        for (int i = 0; i < count; i++) {
            branches[i] = new JButton("");
            branches[i].setSize(50, 50);
            branches[i].setLocation(x, y);
            branches[i].addActionListener(controller.removeBranch);
            frame.add(branches[i]);
            if(i == (int)Math.pow(2,z) - 2){
                x = megaX ;
                megaX -= z*100;
                if(z == 4){x -= 100;}
                y += 100;
                z++;
            }else{
                x += 100;
            }
        }

        frame.add(label);
        frame.setVisible(true);
        label.setSize(20, 20);
    }
    public void deleteTree(){
        try {
            for (JButton branch : branches) {
                frame.remove(branch);
            }
        }catch (NullPointerException npe){
            System.out.println("Its start");
        }
    }
}
