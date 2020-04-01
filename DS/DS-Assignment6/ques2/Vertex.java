package ques2;
public class Vertex {

    private int vertexName;
    private int weight;

    /**
     * Constructor to initialize the data members of the class
     * @param vertexName is the name of the vertex
     * @param weight is the weight of the edge
     */
    public Vertex(int vertexName, int weight) {
        this.vertexName = vertexName;
        this.weight = weight;
    }
    public Vertex() {
        super();
    }

    //getter Setter Methods
    public int getVertex() {
        return vertexName;
    }

    public void setVertexName(int vertexName) {
        this.vertexName = vertexName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}