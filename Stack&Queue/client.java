public class client {
    public static void main(String[] args) throws Exception{
        stack myStack = new stack();
        queue myQueue = new queue();

        // myStack.push(10);
        // myStack.push(20);
        // myStack.push(30);
        // myStack.push(40);
        // myStack.push(50);
        myQueue.add(60);
        myQueue.add(70);
        myQueue.add(80);
        myQueue.add(20);
        myQueue.add(64);
        myQueue.add(34);
        myQueue.add(24);
        myQueue.add(14);

        myQueue.remove();
        myQueue.remove();
        myQueue.remove();
        myQueue.remove();

        myQueue.add(50);
        myQueue.add(60);

        System.out.println(myQueue);
    }   
}
