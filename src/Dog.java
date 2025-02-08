public class Dog extends Animal {

    private static int count;

        public Dog(String _name) {
            super(_name);
    
            this.swimLimit = 10;
            this.runLimit = 500;

            count++;
        }
    
        public static  int getCount(){
            return count;
        }
        
    }
    