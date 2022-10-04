public class Song {

    public String name;
    public String Artist;
    public int ID;
    public String Genre;
    public int year;

    public Song(String name, String Artist, int ID, String Genre, int year) {
        this.name = name;
        this.Artist = Artist;
        this.ID = ID;
        this.Genre = Genre;
        this.year = year;
    }
    
    
    @Override
    public int hashCode(){
        return name.hashCode() + Artist.hashCode() + ID + Genre.hashCode() + year;
    }
    
    @Override
    public String toString() {
        return "Song{" + "Song=" + name + ", Artist=" + Artist + ", ID=" + ID + ", Genre=" + Genre + ", year=" + year + '}';
    }
            
}
