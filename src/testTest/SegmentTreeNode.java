package testTest;



public class SegmentTreeNode{
    public int start, end;
    public SegmentTreeNode left, right;
	public int max;
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
    }
    public SegmentTreeNode(int start, int end,int max) {
        this.start = start;
        this.end = end;
        this.max = max;
        this.left = this.right = null;
    }
}
