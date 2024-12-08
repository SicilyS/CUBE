public class Starship {
    @Override
    public String toString() {
        return name +
                " at " + position +
                " moving " + velocity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector getPosition() {
        return position;
    }
    public Starship (String name, Vector position) {
        this.name = name;
        this.position = position;
        this.velocity = new Vector(0,0);
    }

    public void drift(){
        this.position.x = this.position.x + this.velocity.x;
        this.position.y = this.position.y + this.velocity.y;

    }

    public void accelerate(Vector vector){
        this.velocity.x = vector.x + this.velocity.x;
        this.velocity.y = vector.y + this.velocity.y;
    }
    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    String name;

    Vector position;

    Vector velocity;



}