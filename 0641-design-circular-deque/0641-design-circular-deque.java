class MyCircularDeque {
    int k=0;
    int size=0;
    Queue <Integer> q=new LinkedList<>();
    public MyCircularDeque(int k) {
        this.k=k;
    }
    
    public boolean insertFront(int value) {
      if(size%k==0 && size!=0)
      return false;
      Queue <Integer> st=new LinkedList<>();
      while(!q.isEmpty())
      {
        st.add(q.remove());
      }
      q.add(value);
      while(!st.isEmpty())
      {
        q.add(st.remove());
      }
      size++;
      return true;
    }
    
    public boolean insertLast(int value) {
      if(size%k==0 && size!=0)
      return false;
      q.add(value);
      size++;
      return true;
    }
    
    public boolean deleteFront() {
     if(size==0)
      return false;
      q.remove();
      size--;
      return true;
    }
    
    public boolean deleteLast() {
      if(size==0)
      return false;
      Queue <Integer> st=new LinkedList<>();
      while(q.size()>1)
      {
        st.add(q.remove());
      }
      q.remove();
      while(!st.isEmpty())
      {
        q.add(st.remove());
      }
      size--;
      return true;
    }
    
    public int getFront() {
        if(!q.isEmpty())
        return q.peek();
        return -1;
    }
    
    public int getRear() {
     if(size==0)
     return -1;
      Queue <Integer> st=new LinkedList<>();
      while(q.size()>1)
      {
        st.add(q.remove());
      }
     int z= q.remove();
     st.add(z);
      while(!st.isEmpty())
      {
        q.add(st.remove());
      }
      return z;
    }
    
    public boolean isEmpty() {
        if(size==0)
        return true;
        return false;
    }
    
    public boolean isFull() {
        if(size%k==0 && size!=0)
        return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */