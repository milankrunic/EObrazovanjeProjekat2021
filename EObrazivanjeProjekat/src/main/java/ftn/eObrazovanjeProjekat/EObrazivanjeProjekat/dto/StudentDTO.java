package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.dto;



import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.Student;

public class StudentDTO {
	
	private Long id;
	private String email; 
	private String cardNumber;
	private UserDTO userDTO;

	
	
	public StudentDTO() {
		super();
	}
	
	public StudentDTO(Long id, String email, String cardNumber, UserDTO userDTO) {
		super();
		this.id = id;

		this.email = email;
		this.cardNumber = cardNumber;
		this.userDTO = userDTO;

	}
	
	public StudentDTO(Student student) {
		this(student.getIdStudent(), student.getEmail(), student.getCardNumber(), new UserDTO(student.getUser()));
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}




	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}


	

}
