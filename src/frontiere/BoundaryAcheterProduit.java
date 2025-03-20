package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (controlAcheterProduit.isHabitant(nomAcheteur)) {
			StringBuilder question = new StringBuilder();
			question.append("Quel produit voulez-vous acheter ?\n");
			String produit = Clavier.entrerChaine(question.toString());
			if (controlAcheterProduit.produitExistant(produit)) {
				System.out.println("Chez quel commerçant voulez-vous acheter des "+produit+"?\n");
				controlAcheterProduit.commercantVendantProduit(produit);
				int numVendeur = Clavier.entrerEntier(null);
				String nomVendeur = controlAcheterProduit.choisirCommercant(numVendeur-1, produit);
				if (nomVendeur!=null) {
					System.out.println(nomAcheteur+" se deplace jusqu'à l'étal du vendeur "+nomVendeur);
					System.out.println("Bonjour "+nomAcheteur+"\n");
					StringBuilder question2 = new StringBuilder();
					question2.append("Combien de "+produit+" voulez-vous acheter ?\n");
					int quantiteSouhaite = Clavier.entrerEntier(question2.toString());
					System.out.println(nomAcheteur+" a acheté "+controlAcheterProduit.acheterProduit(nomVendeur, quantiteSouhaite)+" "+produit+" à "+nomVendeur);
				} else {
					System.out.println("Ce commerçant n'existe pas");
				}
			} else {
				System.out.println("Personne ne vend ce produit");
			}
		} else {
			System.out.println("Seul un habitant du village peut vendre ou acheter au marché");
		}
	}
}
