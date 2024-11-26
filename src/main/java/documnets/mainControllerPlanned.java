package documnets;

record Film(){};//video from yt, name, url
record ProcessedFilm(Film f, Transcript t, Shorten[] s){};//video from yt, name, url, transcript, summary
record Model(){};//which AI model to use
record Settings(){};//settings for the model
record Transcript(){};//transcript of the video, from yt
record Shorten(){};//transcript processed by ai
record PLaylist(){} //name or id Bookmark
record UserDetails(){}//from Security

class mainControllerPlanned {
    
    static void clickOnProcess(Film film, Model model, Settings chosen){
        MainService.clickOnProcess(film, model, chosen);
    };

    static void addFilmToLibrary(ProcessedFilm pf){
        MainService.addFilmToLIbrary(pf);
    }

    static void renderPage(){
        Securty.getUserDetails();
        MainService.preparePage();
    }

    static void pushFilmToPlaylist(Film f, PLaylist p){
        MainService.pushFilmToPlaylist(f, p);
    }

    static void addFilmToBench(Film f){
        //film exists, can be processed;
        MainService.addFilmToBench(f);
    }

}

//Main Logic
class MainService {
    static void clickOnProcess(Film film, Model model, Settings chosen) {
        Transcript t = YTService.getTranscript(film);
        Shorten[] s = AIService.process(film, t);
        LibraryService.addFilmToLibrary(film, t, s);
    }

    static void preparePage(){
        LibraryService.getPartOdLibrary(10,1 );
        AIService.getModels();
        YTService.getPlaylists();
    }
    static void addFilmToLIbrary(Film film, Transcript t, Shorten[] s){
        LibraryService.addFilmToLibrary(film, t , s);
    }
    static void addFilmToLIbrary(ProcessedFilm pf){
        LibraryService.addFilmToLibrary(pf);
    }

    public static void pushFilmToPlaylist(Film f, PLaylist p) {
        YTService.pushFilmToPlaylist(f, p);
    }

    public static void addFilmToBench(Film f) {
        Transcript t = YTService.getTranscript(f);
        LibraryService.addFilmToBench(f, t);
    }
}


//stores results in db
class LibraryService {
    static void addFilmToLibrary(Film film, Transcript t, Shorten[] s) {
        //store film in db
    }
    static void addFilmToLibrary(ProcessedFilm pf) {
        //store film in db
    }
    static Film[] getPartOdLibrary(int n, int offset){ return null;};
    static Film getFilm(){ return null; }
    static void addFilmToBench(Film f, Transcript t){};
    static Film[] getBench(){return null;}
}

//connector to external AI model, OpenAI, etc.
class AIService{
    static Shorten[] process(Film film, Transcript t) {return null;}
    static Model[] getModels(){return null;};

}

//connection to yt
class YTService{
   static Transcript getTranscript(Film film){ return null; }
    static Film getFilm(String url){ return null; }
    static PLaylist[] getPlaylists(){return null;};

    public static void pushFilmToPlaylist(Film f, PLaylist p) {

    }

}

class Securty{
    static UserDetails getUserDetails(){return null;}
}