// אלעד כהן - 318918968
// עמית קפלן - 209049972

package MST;

public class AdjNode {
    private int id;
    private double weight;

    public AdjNode(int id, double weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
