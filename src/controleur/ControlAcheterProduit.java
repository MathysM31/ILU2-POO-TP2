package controleur;

import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isHabitant(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	
	public boolean produitExistant(String produit) {
		return village.rechercherVendeursProduit(produit)!=null;
	}
	
	public void commercantVendantProduit(String produit) {
		int nbVendeurs = village.rechercherVendeursProduit(produit).length;
		for (int i = 0; i < nbVendeurs; i++) {
			System.out.println((i+1)+" - "+ village.rechercherVendeursProduit(produit)[i].getNom());
		}
	}
	
	public String choisirCommercant(int numCommercant, String produit) {
		if (numCommercant < village.rechercherVendeursProduit(produit).length && (village.rechercherVendeursProduit(produit)[numCommercant]!=null)) {
			return village.rechercherVendeursProduit(produit)[numCommercant].getNom();
		}
		return null;
	}
	
	public int acheterProduit(String vendeur, int quantite) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(vendeur).acheterProduit(quantite);
	}
}
