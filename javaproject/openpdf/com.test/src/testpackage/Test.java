package testpackage;
public class Test {

	public static void main(String[] args) {
		try {
			ExampleOpenPdf report = new ExampleOpenPdf();
			byte[] param = "{\"Companies\":[{\"Name\":\"HyperWare Group Ltd.\",\"Employees\":[{\"Name\":\"Fives,Maureen M.\",\"Title\":\"Global Systems Engineer\"},{\"Name\":\"Jung,Lawrence Y.\",\"Title\":\"Global Accounts Rep.\"},{\"Name\":\"Quilty,Martin M.\",\"Title\":\"Senior Developer\"},{\"Name\":\"Noodleman,Chris C.\",\"Title\":\"Associate Accountant\"},{\"Name\":\"Finn,Mary M.\",\"Title\":\"Associate Developer\"}]},{\"Name\":\"IntraData LLC.\",\"Employees\":[{\"Name\":\"Wilson,Michael U.\",\"Title\":\"Senior Developer\"},{\"Name\":\"Yancik,Nataliya L.\",\"Title\":\"Executive Hygienist\"},{\"Name\":\"Black,Chris V.\",\"Title\":\"Laboratory Sales Rep.\"},{\"Name\":\"Schulte,Olga D.\",\"Title\":\"Associate Hygienist\"}]},{\"Name\":\"OctoTech Associates\",\"Employees\":[{\"Name\":\"Eno,Bart P.\",\"Title\":\"Assistant Developer\"},{\"Name\":\"Mailer,Imelda P.\",\"Title\":\"Associate Director\"},{\"Name\":\"Allen,Valery A.\",\"Title\":\"Laboratory Resources Director\"},{\"Name\":\"Klausner,Lola S.\",\"Title\":\"Senior Product Manager\"},{\"Name\":\"Pape,Keith R.\",\"Title\":\"Technician\"}]},{\"Name\":\"PicoSoft Gmbh.\",\"Employees\":[{\"Name\":\"Quigley,Barb W.\",\"Title\":\"Strategic Engineer\"},{\"Name\":\"Jafari,Laura X.\",\"Title\":\"Executive Marketing Manager\"},{\"Name\":\"Eagleman,Rhonda P.\",\"Title\":\"Executive Engineer\"},{\"Name\":\"Gomez,Mark H.\",\"Title\":\"Senior Support Engineer\"},{\"Name\":\"Ironhorse,Mark P.\",\"Title\":\"Global Engineer\"}]},{\"Name\":\"XenaLateral LLC.\",\"Employees\":[{\"Name\":\"DeLillo,Phil O.\",\"Title\":\"Executive Accounts Rep.\"},{\"Name\":\"Tweed,Alvin O.\",\"Title\":\"Global Product Specialist\"},{\"Name\":\"Schulte,John T.\",\"Title\":\"Senior Administrator\"},{\"Name\":\"Roentgen,Janice R.\",\"Title\":\"Executive Support Engineer\"},{\"Name\":\"Vonnegut,Alvin A.\",\"Title\":\"Senior Resources Director\"},{\"Name\":\"Avery,Rhonda C.\",\"Title\":\"Accounts Rep.\"},{\"Name\":\"Jones,Belinda K.\",\"Title\":\"Laboratory Support Engineer\"},{\"Name\":\"Isaacs,Elvira Q.\",\"Title\":\"Strategic Support Engineer\"},{\"Name\":\"Jackson,Natasha D.\",\"Title\":\"Global Technician\"},{\"Name\":\"Ravazzolo,Susan N.\",\"Title\":\"Laboratory Technician\"},{\"Name\":\"Smyth,Molly N.\",\"Title\":\"Senior Engineer\"}]}]}"
					.getBytes();
			byte[] result = report.execute(param);
			System.out.println("Call result: " + new String(result).substring(0,20));
		} catch (Throwable e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
