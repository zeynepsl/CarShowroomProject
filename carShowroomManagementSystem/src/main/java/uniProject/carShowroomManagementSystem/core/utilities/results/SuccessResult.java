package uniProject.carShowroomManagementSystem.core.utilities.results;

public class SuccessResult extends Result{

	//alt sınıf, üst sınıfın kurucu metotlarını miras alamaz
	
	//kurucu metodun ilk görevi: anne babasının kurucu metotlarını çağırmaktır
	//çünkü benim doğmam için önce anne ve babamın doğması lazım
	//üst sınıfın kurucu metodu -> super() --yazmasak da java   çalıştırır.
	public SuccessResult() {
		super(true);
	}
	
	public SuccessResult(String message) {
		super(true, message);
	}

}
