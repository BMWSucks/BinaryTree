import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller {
    Model model;
    Viewer viewer;

    public Controller(Viewer viewer) {
        model = new Model(viewer);
        this.viewer = viewer;
    }

    public Model getModel() {
        return model;
    }

    ActionListener add = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.addBranch();
            if (viewer.rb.isSelected()) {
                model.tree.checking();
            }
        }
    };
    ActionListener remove = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.tree.remove();
            if (viewer.rb.isSelected()) {
                model.tree.checking();
            }
        }
    };
    ActionListener check = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.tree.checking();

        }
    };
    ActionListener create = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            viewer.deleteTree();
            model.createRoot();

        }
    };
    ActionListener removeBranch = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < viewer.branches.length; i++) {
                if (e.getSource() == viewer.branches[i]) {
                    model.tree.remove(i);
                    if (viewer.rb.isSelected()) {
                        model.tree.checking();
                    }
                }
            }
        }
    };
    KeyListener keyPressed = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

            switch (e.getKeyChar()){
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '8':
                case '7':
                case '9':
                    clearTextField();
                    break;
                default:
                    System.out.println("asd");
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            {
                switch (e.getKeyChar()) {
                    case 'a':
                        clearTextField();
                        model.addBranch();
                        if (viewer.rb.isSelected()) {
                            model.tree.checking();
                        }
                        break;
                    case 'r':
                        clearTextField();
                        model.tree.remove();
                        if (viewer.rb.isSelected()) {
                            model.tree.checking();
                        }
                        break;
                    case 'c':
                        clearTextField();
                        try {
                            viewer.deleteTree();
                        }catch (NullPointerException npe){
                            System.out.println("Its start");
                        }
                        model.createRoot();
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '6':
                    case '5':
                    case '8':
                    case '7':
                    case '9':
                        System.out.println("Number");
                        break;
                    default:
                        clearTextField();

                }


            }
        }

        public void clearTextField() {

            String str = viewer.tf.getText();
            if (str.length() < 1) {
                viewer.tf.setText("");
            } else {
                viewer.tf.setText(str.substring(0, str.length() - 1));
            }
        }
    };
}
