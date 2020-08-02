class MedianFinder {

    /** initialize your data structure here. */
    List<Integer> list = new ArrayList<>();
    int size;
    public MedianFinder() {
        size = list.size();
    }

    public void addNum(int num) {
         list.add(num);
         size+=1;
         Collections.sort(list);
    }

    public double findMedian() {
        if(!list.isEmpty())
        {
            if(size%2==1)
                return list.get(size/2);
            else
                return (list.get(size/2)+list.get(size/2-1))/2.0;
        }
        else
            return 0.0;
    }
}

/**
 * 方法2：
 */
class MedianFinder {

    /** initialize your data structure here. */
    Queue<Integer> A = new PriorityQueue<>((x,y)->(y-x));
    Queue<Integer> B = new PriorityQueue<>();
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(A.size()!=B.size())
        {
            A.add(num);
            B.add(A.poll());
        }
        else
        {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
       if(A.size()==B.size())
           return (A.peek()+B.peek())/2.0;
       else if(A.size()<B.size())
           return B.peek();
       else
           return A.peek();
    }
}
