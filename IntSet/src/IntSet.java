public class IntSet {
    private Vector els;

    public IntSet(){
        els = new vector();
    }

    public void insert (int x){
        Integer y = new Integer(x);
        if (getIndex(y) < 0) els.add(y);
    }

    public void remove (int x){
        int i = getINdex(new INteger(x));
        if (i<0) return;
        els.set(i, els.lastElement());
        els.remove(els.size()-1);
    }

    public int size(){
        return els.size();
    }

    public int choose() throws EmptyException{
        if (els.size()==0) throw new EmptyException("IntSet.choose");
        return els.lastElement();
    }
}
