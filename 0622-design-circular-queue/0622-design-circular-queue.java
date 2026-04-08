class MyCircularQueue {
    int[] arr;
    int front, rear, size;

    public MyCircularQueue(int k) {
        size = k;
        arr = new int[k];
        front = -1;
        rear = -1;
    }

    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            front = rear = 0;
        }else{
            rear = (rear +1)%size;
        }
        arr[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(front == rear){
            front = rear = -1;
        }else{
            front = (front + 1)%size;
        }
        return true;
        
    }
    
    public int Front() {
        return isEmpty() ? -1 :arr[front];
        
    }
    
    public int Rear() {
        return isEmpty() ?-1: arr[rear];
        
    }
    
    public boolean isEmpty() {
        return front == -1;
        
    }
    
    public boolean isFull() {
        return front == (rear +1)% size;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */