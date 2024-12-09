# diagrames
classDiagram
    class interface {
        +ajouter()
        +recuperer()
        +mettreAJour()
        +supprimer()
    }

    class Vol {
        -Long id
        +String numeroVol
        +LocalDate dateVol
        +String origine
        +String destination
        +Compagnie compagnie
        +Avion avion
        
    }

    class Avion {
        +Long id
        +String type
        +int capacite
        +int anneeFabrication
    }

    class Passager {
        -Long id
        -String nom
        -String numPasseport
        -LocalDate dateNaissance
        -String nationalite
        -String email
        -String telephone
    }

    class Reservation {
        -Long id
        -String statut
        -Date dateReservation
        -Vol vol
        -List passagers
        -double prixTotal
    }

    class Equipage {
        -Long id
        -String nom
        -String fonction
        -String numLicence
        -String nationalite
    }

    class Aeroport {
        +String codeIATA
        +String nom
        +String ville
        +String pays
        +int capacite
    }

    Avion --> Vol : association 
    Vol --> Passager : association 
    Passager ..> Reservation : dépendance 
    Vol --* Equipage : composition
    Aeroport ..> Vol : dépendance 
    Avion ..|> interface : realisation
    Passager ..|> interface : realisation
    Reservation ..|> interface : realisation
    Equipage ..|> interface : realisation
    Aeroport ..|> interface : realisation
    Vol --> Reservation : association 
    Vol ..|> interface : realisation
