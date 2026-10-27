public class Task6 {

    interface Weapon {
        void use();
    }

    static class Sword implements Weapon {
        @Override
        public void use() {
            System.out.println("Slash! Dealing 20 physical damage.");
        }
    }

    static class MagicWand implements Weapon {
        @Override
        public void use() {
            System.out.println("Zap! Dealing 35 magic damage.");
        }
    }

    static abstract class Hero {
        protected Weapon weapon;
        Hero(Weapon weapon) {
            this.weapon = weapon;
        }

        public abstract void attack();
    }

    static class Knight extends Hero {
        Knight(Weapon weapon) {
            super(weapon);
        }

        @Override
        public void attack() {
            weapon.use();
        }
    }

    static class Wizard extends Hero {
        Wizard(Weapon weapon) {
            super(weapon);
        }

        @Override
        public void attack() {
            weapon.use();
        }
    }

    public static void main(String[] args) {
        Hero knightWithSword = new Knight(new Sword());
        knightWithSword.attack();

        Hero knightWithWand = new Knight(new MagicWand());
        knightWithWand.attack();
    }
}