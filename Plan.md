class Film {
+name: String
+url: String
}

class ProcessedFilm {
+Film f
+Transcript t
+Shorten[] s
}

class Model {}

class Settings {}

class Transcript {
+content: String
}

class Shorten {
+processedContent: String
}

class PLaylist {
+name: String
+id: String
}

class UserDetails {
+username: String
+roles: String[]
}

class mainControllerPlanned {
+clickOnProcess(Film, Model, Settings)
+addFilmToLibrary(ProcessedFilm)
+renderPage()
+pushFilmToPlaylist(Film, PLaylist)
+addFilmToBench(Film)
}

class MainService {
+clickOnProcess(Film, Model, Settings)
+preparePage()
+addFilmToLibrary(Film, Transcript, Shorten[])
+addFilmToLibrary(ProcessedFilm)
+pushFilmToPlaylist(Film, PLaylist)
+addFilmToBench(Film)
}

class LibraryService {
+addFilmToLibrary(Film, Transcript, Shorten[])
+addFilmToLibrary(ProcessedFilm)
+getPartOfLibrary(int, int): Film[]
+getFilm(): Film
+addFilmToBench(Film, Transcript)
+getBench(): Film[]
}

class AIService {
+process(Film, Transcript): Shorten[]
+getModels(): Model[]
}

class YTService {
+getTranscript(Film): Transcript
+getFilm(String): Film
+getPlaylists(): PLaylist[]
+pushFilmToPlaylist(Film, PLaylist)
}

class Securty {
+getUserDetails(): UserDetails
}

mainControllerPlanned --> MainService
MainService --> LibraryService
MainService --> AIService
MainService --> YTService
mainControllerPlanned --> Securty
LibraryService --> Film
LibraryService --> Transcript
LibraryService --> Shorten
AIService --> Film
AIService --> Transcript
YTService --> Film
YTService --> Transcript
YTService --> PLaylist
Securty --> UserDetails