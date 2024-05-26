package problem018.model;



public class NumbersPyramidNode {

    private final int value;
    private int pathSum;
    public NumbersPyramidNode(int value) {
        this.value = pathSum = value;
    }

    public int getPathSum() {
        return pathSum;
    }

    public void calculatePathSum(int val) {
        pathSum += val;
    }

    @Override
    public String toString() {
        return "NumbersPyramidNode{" +
                "value=" + value +
                ", pathSum=" + pathSum +
                '}';
    }
}
