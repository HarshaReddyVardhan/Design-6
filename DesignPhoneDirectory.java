SC : O(MaxNumbers)
TC : 
get --> O(1)
check --> O(1)
release --> O(1)


public class PhoneDirectory {
    HashSet<Integer> set;
    Queue<Integer> q;
    int cap;
    public PhoneDirectory(int maxNumbers) {
        this.set = new HashSet<>();
        this.q = new LinkedList<>();
        for(int i=0; i< maxNumbers; ++i){
            set.add(i);
            q.add(i);
        }
        this.cap = maxNumbers;
    }

    /**
     * @return: the available number of the phone directory 
     */
    public int get() {
        if(q.isEmpty()) return -1;
        int x = q.poll();
        set.remove(x);
        return x;
    }

    /**
     * @param number: the number to be checked
     * @return: check whether the number of the phone directory is available
     */
    public boolean check(int number) {
        if(number < 0 || number >= cap) return false;
        return set.contains(number);
    }

    /**
     * @param number: the number of the phone directory to be released
     * @return: nothing
     */
    public void release(int number) {
        if(number < 0 || number >= cap) return;
        if(!set.contains(number)) {
            q.add(number);
            set.add(number);
        }
    }
}
