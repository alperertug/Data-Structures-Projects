
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        DataInputStream dataIn = new DataInputStream(new FileInputStream("songs.txt"));
        String recievedData;
        SongTree<Integer> tID = new SongTree<>();
        SongTree<Integer> tArtist = new SongTree<>();
        SongTree<Integer> tGenre = new SongTree<>();
        SongTree<Integer> tName = new SongTree<>();
        SongTree<Integer> tYear = new SongTree<>();
        SeparateChainHash<Song> songTable = new SeparateChainHash<>(30);
        while (true) {
            recievedData = dataIn.readLine();
            if (recievedData == null) {
                break;
            }
            String[] songArray = recievedData.split(";");
            Song newSong = new Song(songArray[0], songArray[1], Integer.parseInt(songArray[2]), songArray[3], Integer.parseInt(songArray[4]));
            songTable.insert(newSong);
            tID.addNode(newSong.ID, newSong.hashCode());
            tArtist.addNode(code(newSong.Artist.toLowerCase()), newSong.hashCode());
            tGenre.addNode(code(newSong.Genre.toLowerCase()), newSong.hashCode());
            tName.addNode(code(newSong.name.toLowerCase()), newSong.hashCode());
            tYear.addNode(newSong.year, newSong.hashCode());
        }

        while (true) {
            mainMenu();
            System.out.print("Choice: ");
            String value = scanner.nextLine();
            System.out.print("");
            if (value.equals("6")) {
                break;
            } else if (value.equals("1")) {
                songTable.getSize();
                System.out.println(songTable.toString());
            } else if (value.equals("2")) {
                System.out.print("Song name: ");
                String songName = scanner.nextLine();
                System.out.print("Song artist: ");
                String songArtist = scanner.nextLine();
                System.out.print("Song ID: ");
                String songID = scanner.nextLine();
                System.out.print("Song genre: ");
                String songGenre = scanner.nextLine();
                System.out.print("Song year: ");
                String songYear = scanner.nextLine();
                int ctrl = tID.searchID(Integer.parseInt(songID));
                if (ctrl != -1) {
                    System.out.println("This ID is already exist!");
                } else {
                    Song addSong = new Song(songName, songArtist, Integer.parseInt(songID), songGenre, Integer.parseInt(songYear));
                    songTable.insert(addSong);
                    tID.addNode(addSong.ID, addSong.hashCode());
                    tArtist.addNode(code(addSong.Artist.toLowerCase()), addSong.hashCode());
                    tGenre.addNode(code(addSong.Genre.toLowerCase()), addSong.hashCode());
                    tName.addNode(code(addSong.name.toLowerCase()), addSong.hashCode());
                    tYear.addNode(addSong.year, addSong.hashCode());
                    System.out.println("The song is successfully added!");
                }
            } else if (value.equals("3")) {
                System.out.print("Enter the ID to deleting a song: ");
                String dltInt = scanner.nextLine();
                if (ifNotInt(dltInt) == -1) {
                    continue;
                }
                int hCode = tID.searchID(Integer.parseInt(dltInt));
                if (hCode == -1) {
                    System.out.println("This ID is not exist!");
                    continue;
                }
                Song ssSong = songTable.delete(hCode);
                tID.delete(ssSong.ID, hCode);
                tArtist.delete(code(ssSong.Artist.toLowerCase()), hCode);
                tGenre.delete(code(ssSong.Genre.toLowerCase()), hCode);
                tName.delete(code(ssSong.name.toLowerCase()), hCode);
                tYear.delete(ssSong.year, hCode);
                System.out.println("The song is removed!");
            } else if (value.equals("4")) {
                searchMenu();
                System.out.print("Choice: ");
                String swStr = scanner.nextLine();
                switch (swStr) {
                    case "1":
                        System.out.print("ID: ");
                        String inputID = scanner.nextLine();
                        if(ifNotInt(inputID) == -1){
                            continue;
                        }
                        int sID = tID.searchID(Integer.parseInt(inputID));
                        System.out.println(songTable.find(sID));
                        break;
                    case "2":
                        System.out.print("Artist: ");
                        String inputArt = scanner.nextLine();
                        int[] sArt = tArtist.searchU(code(inputArt.toLowerCase()));
                        for (int i = 0; i < sArt.length; i++) {
                            System.out.println(songTable.find(sArt[i]));
                        }
                        break;
                    case "3":
                        System.out.print("Song name: ");
                        String inputName = scanner.nextLine();
                        int[] sName = tName.searchU(code(inputName.toLowerCase()));
                        for (int i = 0; i < sName.length; i++) {
                            System.out.println(songTable.find(sName[i]));
                        }
                        break;
                    case "4":
                        System.out.print("Genre: ");
                        String inputGenre = scanner.nextLine();
                        int[] sGen = tGenre.searchU(code(inputGenre.toLowerCase()));
                        for (int i = 0; i < sGen.length; i++) {
                            System.out.println(songTable.find(sGen[i]));
                        }
                        break;
                    case "5":
                        System.out.print("Year: ");
                        String inputYear = scanner.nextLine();
                        if(ifNotInt(inputYear) == -1){
                            continue;
                        }
                        int[] sYear = tYear.searchU(Integer.parseInt(inputYear));
                        for (int i = 0; i < sYear.length; i++) {
                            System.out.println(songTable.find(sYear[i]));
                        }
                        break;

                    default:
                        System.out.println("Invalid input!");
                        break;
                        
                }
            } else if (value.equals("5")) {
                System.out.print("Enter the lower bound: ");
                String lower = scanner.nextLine();
                if(ifNotInt(lower) == -1){
                    continue;
                }
                System.out.print("Enter the upper bound: ");
                String upper = scanner.nextLine();
                if(ifNotInt(upper) == -1){
                    continue;
                }
                int[] bound = tID.bound(Integer.parseInt(lower), Integer.parseInt(upper));
                if (bound.length == 0) {
                    System.out.println("Song not found!");
                }

                for (int i = 0; i < bound.length; i++) {
                    System.out.println(songTable.find(bound[i]));
                }
                
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    public static void mainMenu() {
        System.out.println("   Song Menu\n"
                + "1:Show Song List\n"
                + "2:Insert song\n"
                + "3:Delete song\n"
                + "4:Search\n"
                + "5:Search for songs within a given bound\n"
                + "6:Exit");

    }

    public static void searchMenu() {
        System.out.println("1:ID\n"
                + "2:Artist\n"
                + "3:Song Name\n"
                + "4:Song Genre\n"
                + "5:Song Year");
    }

    public static int code(String s) {
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            value = s.charAt(i) + (15 * value);
        }
        return value;
    }
    
    public static int ifNotInt(String s){
        try {
            int tmp = Integer.parseInt(s);
            return tmp;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!\n"
                    + "Error: " + e);
        }
        return -1;
    }
}
