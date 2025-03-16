import { useState } from "react";
import axios from 'axios'

export default function Signup( props ){

      // 입력값 상태 관리
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [name, setName] = useState("");
  const [profileImage, setProfileImage] = useState(null);
  const [preview, setPreview] = useState(null);

  // 프로필 이미지 선택 시 처리
  const handleProfileImageChange = (e) => {
    const file = e.target.files[0];
    setProfileImage(file);
    // 이미지 미리보기
    if (file) {
      const reader = new FileReader();
      reader.onloadend = () => {
        setPreview(reader.result);
      };
      reader.readAsDataURL(file);
    } else {
      setPreview(null);
    }
  };

  // 폼 제출 시 처리 (예: API 호출)
  const onSignup = async (e) => {
    e.preventDefault();

    // 파일 업로드가 포함된 데이터를 전송하려면 FormData 사용
    const formData = new FormData();
    formData.append("mid", email);
    formData.append("mpwd", password); // API 필드명에 맞게 조정
    formData.append("mname", name);
    // 프로필 이미지가 선택된 경우만 추가
    if (profileImage) {
      formData.append("mimg", profileImage);
    }

    // 예시: axios를 사용하여 회원가입 API 호출
    const response = await axios.post("http://localhost:8080/api/member/signup", formData, {
      headers: { "Content-Type": "multipart/form-data" }
    })

    if( response.data  ){
        console.log("회원가입 성공");
    }else{
        console.log("회원가입 에러");
    }
  };

  // 


  return (
    <div>
      <h2>회원가입 페이지</h2>
      <form >
        <div>
          <label htmlFor="email">이메일: </label>
          <input 
            id="email"
            type="email" 
            value={email} 
            onChange={(e) => setEmail(e.target.value)} 
            required 
          />
        </div>
        <div>
          <label htmlFor="password">비밀번호: </label>
          <input 
            id="password"
            type="password" 
            value={password} 
            onChange={(e) => setPassword(e.target.value)} 
            required 
          />
        </div>
        <div>
          <label htmlFor="name">이름: </label>
          <input 
            id="name"
            type="text" 
            value={name} 
            onChange={(e) => setName(e.target.value)} 
            required 
          />
        </div>
        <div>
          <label htmlFor="profileImage">프로필 이미지: </label>
          <input 
            id="profileImage"
            type="file" 
            accept="image/*" 
            onChange={handleProfileImageChange}
          />
          {preview && (
            <div>
              <p>미리보기:</p>
              <img 
                src={preview} 
                alt="Profile Preview" 
                style={{ width: "100px", height: "100px", objectFit: "cover" }} 
              />
            </div>
          )}
        </div>
        <button type="button" onClick={ onSignup }>회원가입</button>
      </form>
    </div>
  )

}