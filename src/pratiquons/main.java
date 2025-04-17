package pratiquons;

import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		VolDAO volDAO = new VolDAO();
		int choix ;
		do {
			
			System.out.println("\n====== MENU ======");
			System.out.println("1. Afficher tous les vols");
			System.out.println("2. Ajouter un nouveau vol");
			System.out.println("3. Modifier la destination d’un vol");
			System.out.println("4. Quitter");
			System.out.print("Votre choix : ");
			
		while (!scanner.hasNextInt()){
			 System.out.print("Veuillez entrer un nombre valide : ");
			 scanner.next();
		}
		choix = scanner.nextInt();
		scanner.nextLine();
		switch(choix){
		case 1:
			List<vol> vols = volDAO.getvols();
			if (vols.isEmpty()){
				System.out.println("Aucun vol trouvé.");
			}else {
				for (vol v : vols) {
					System.out.println(v);
				}
			}
			break;
        case 2:
            System.out.print("Numéro du vol : ");
            String num = scanner.nextLine();
            System.out.print("Ville de départ : ");
            String dep = scanner.nextLine();
            System.out.print("Ville d'arrivée : ");
            String arr = scanner.nextLine();
            volDAO.ajouterVol(new vol(num, dep, arr));
            System.out.println("Vol ajouté avec succès !");
            break;
        case 3:
            System.out.print("Numéro du vol à modifier : ");
            String numMod = scanner.nextLine();
            vol vol = volDAO.chercherVol(numMod);
            if (vol == null) {
                System.out.println("Ce vol n'existe pas.");
            } else {
                System.out.print("Nouvelle ville d'arrivée : ");
                String nouvelleDest = scanner.nextLine();
                volDAO.modifierDestination(numMod, nouvelleDest);
                System.out.println("Destination modifiée !");
            }
            break;
        case 4:
            System.out.println("Au revoir !");
            break;
        default:
            System.out.println("Choix invalide !");
			}
		}while (choix !=4);
	}

}
