package Model.Location;

/**
 * Created by Trevor on 4/14/2017.
 */
public class Location {
    int x;
    int y;
    boolean equals(Location location2){
        return location2.getX()==this.getX() && location2.getY()==this.getY();
    }
    public boolean equals(int x, int y){
        return this.x==x && this.y==y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void  setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}

    public Location(int row, int col){
        this.x= row;
        this.y= col;
    }

    public Location(Location location){
        this.x = x;
        this.y = y;
    }

    public Location getNorth() {
        return new Location(getX() - 1, getY());
    }
    public Location getSouth() {
        return new Location( getX() + 1, getY());
    }
    public Location getNorthWest() {
        if (getY() % 2 == 0)
            return new Location(getX() - 1, getY() - 1);
        else
            return new Location(getX(), getY() - 1);
    }
    public Location getSouthWest() {
        if (getY() % 2 == 0)
            return new Location(getX(), getY() - 1);
        else
            return new Location(getX() + 1, getY() - 1);
    }
    public Location getNorthEast() {
        if (getY() % 2 == 0)
            return new Location(getX() - 1, getY() + 1);
        else
            return new Location(getX(), getY() + 1);
    }
    public Location getSouthEast() {
        if (getY() % 2 == 0)
            return new Location(getX(), getY() + 1);
        else
            return new Location(getX() + 1, getY() + 1);
    }
    public void print(){
        System.out.println("X:"+x+" Y:"+y);
    }
}
