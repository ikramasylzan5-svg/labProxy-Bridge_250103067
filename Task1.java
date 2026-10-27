
public class Task1 {
 
    interface Image {
        void show();
    }
 
    static class RealImage implements Image {
        private final String fileName;
 
        RealImage(String fileName) {
            this.fileName = fileName;
            System.out.println("--> [SLOW] Reading " + fileName + " from hard drive...");
        }
 
        @Override
        public void show() {
            System.out.println("Displaying " + fileName + " on screen!");
        }
    }
 
    static class ProxyImage implements Image {
        private final String fileName;
        private final String userRole;
        private RealImage realImage;
 
        public ProxyImage(String fileName, String userRole) {
            this.fileName = fileName;
            this.userRole = userRole;
        }
 
        @Override
        public void show() {
            if (!"ADMIN".equals(userRole)) {
                System.out.println("[ACCESS DENIED] You lack permission to view: " + fileName);
                return;
            }
            if (realImage == null) {
                realImage = new RealImage(fileName); 
            }
            realImage.show();
        }
    }
 
    public static void main(String[] args) {
        Image guest = new ProxyImage("salary_sheet.png", "GUEST");
        Image admin = new ProxyImage("salary_sheet.png", "ADMIN");
        guest.show();
        admin.show();
    }
}
 