class ProA {
        String key1;
        String key2;
        Object o;

        public ProA() {}

        public ProA(String key1, String key2, String v1, Object o) {
            this.key1 = key1;
            this.key2 = key2;
            this.o = o;
        }
    }


public class CustomComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            ProA a = (ProA) o1;
            ProA b = (ProA) o2;
            if (a.key1 != b.key1) {
                return a.key1.compareTo(b.key1);
            } else {
                return a.key2.compareTo(b.key2);
            }
        }
    }

/*应用*/
ProA[] proA = new ProA[];
Arrays.sort(proA, new CustomComparator());
