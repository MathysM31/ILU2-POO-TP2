package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis d�sol�e "+nomVendeur+" mais il faut �tre un habitant de notre village pour commencer ici.");			
		} else {
			System.out.println("Bonjour "+ nomVendeur +", je vais regarder si je peux vous trouvez un etal.");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("D�sol�e "+nomVendeur+" je n'ai plus d'�tal qui ne soit d�j� occup�.");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
