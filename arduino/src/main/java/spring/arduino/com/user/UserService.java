package spring.arduino.com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.arduino.com.DTO.UserDTO;
import spring.arduino.com.domain.UserDomain;

@Controller
public class UserService {

	@Autowired
	private UserMapper mapper;
	
	public void ins_user(UserDTO dto) {
		
		UserDomain vo = mapper.selUser(dto);
		
		if(!vo.getUser_id().equals("")) {
			System.out.println("확인");
			return;
		}
		
		mapper.ins_user(dto);
	}
	
	public int loginProc(UserDTO dto) {
		
		UserDomain vo =  mapper.selUser(dto);
		
		if(vo == null) {
			return 2;
		}
		
		return 1;
	}
	
	
}
