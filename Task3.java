public class Task3 {

    interface Internet {
        void connectTo(String site);
    }

    static class RealInternet implements Internet {
        @Override
        public void connectTo(String site) {
            System.out.println("Connected to site: " + site);
        }
    }

    static class SchoolProxyInternet implements Internet {
        private RealInternet realInternet;

        @Override
        public void connectTo(String site) {
            if ("gaming.com".equals(site) || "socialmedia.com".equals(site)) {
                System.out.println("[BLOCKED BY FIREWALL] Cannot access: " + site);
                return;
            }
            if (realInternet == null) {
                realInternet = new RealInternet();
            }
            realInternet.connectTo(site);
        }
    }

    public static void main(String[] args) {
        Internet internet = new SchoolProxyInternet();
        internet.connectTo("wikipedia.org");
        internet.connectTo("gaming.com");
    }
}