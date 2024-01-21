package item;

import base.Human;
import base.Item;
import enums.Color;
import base.Position;

public class Grave extends Item {
    private final Corpse owner;
    private final Edge edge;
    public Grave(String name, Corpse owner){
        super(name);
        this.owner = owner;
        edge = new Edge("край могилы");
    }
    public Edge getEdge(){
        return edge;
    }

    public void setEdgeColor(Color color) {
        this.edge.color = color;
    }

    public class Edge extends Item implements Position {
        private Color color;
        public Edge(String name) {
            super(name);
        }
        public Color getColor(){
            return color;
        }
        @Override
        public void addPosition(Human human) {
            human.addPos(this);
        }
        @Override
        public void addPosition(Item item) {
            item.addPos(this);
        }
        @Override
        public String toString() {
            return name + owner +"а";
        }
    }
}
