package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println("Le marche est vide, revenez plus tard");
		} else {
			System.out.println(nomAcheteur+", vous trouverez au marche :");
			int i=0;
			String vendeur,quantite,produit;
			while (i<infosMarche.length) {
				vendeur = infosMarche[i];
				i++;
				quantite = infosMarche[i];
				i++;
				produit = infosMarche[i];
				i++;
				System.out.println("-"+ vendeur +" qui vend "+ quantite +" "+ produit);
			}
		}
	}
}
