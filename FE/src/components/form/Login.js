import React, { useState,useEffect,useRef } from 'react'
import { Form, Button, Image } from 'react-bootstrap'
import banner from '../../../src/banner.png'
import { Link } from 'react-router-dom'
import { selectUser } from '../../saga/user/userSlice';
import { useDispatch,useSelector } from 'react-redux';
import { userAction } from '../../saga/user/userSlice';
import Alert from 'react-bootstrap/Alert';

// export const AlertCustom = (props) => {
//   if(props.status > 0) {
//   return (
//     <Alert variant="success">
//       <Alert.Heading>Login success</Alert.Heading>
//       <Alert.Link href="/product">see more product</Alert.Link>
//     </Alert>
//   );}
// }

export default function Login(props) {
  
  const username = useRef(null);
  const password = useRef(null);
    const initialFormData = {
        username: "",
        password: ""
      };
    const [formData, updateFormData] = useState(initialFormData);
    const [status, updateStatus ] = useState(0);
    const dispatch = useDispatch();
    const handleClick = (e) => {
        updateFormData({
          ...formData,
          username: username.current.value,
          password: password.current.value
        });
        updateStatus(1);
        
      };
    useEffect(() => {
      if(status == 1){
        props.selectData(formData);
        props.selectStatus(status);
        
      };
      // if(localStorage.getItem("token")){
      //   window.location.assign("http://localhost:3000/product");
      // }
    },[status])
  return (
    <div style={{display: 'flex'}}>
    <div style={{width: 500,margin: 100}}>
        <h2>Login</h2>
        <Form>
            <Form.Group className="mb-3" controlId="formBasicEmail" style={{width: 400,marginTop: 50,marginLeft: 40}}>
                <Form.Control type="text" placeholder="Enter username" name="username" ref={username}/>
                {/* <Form.Text className="text-muted">
                We'll never share your email with anyone else.
                </Form.Text> */}
            </Form.Group>

            <Form.Group className="mb-3" controlId="formBasicPassword" style={{width: 400,marginTop: 50,marginLeft: 40}}>
                <Form.Control type="password" placeholder="Password" name="password" ref={password}/>
            </Form.Group>
            <Button variant="primary" type="button" style={{width: 200,marginTop: 50}} onClick={handleClick}>
                Submit
            </Button>
            <br />
            <Form.Text style={{marginTop: 30,float: 'right'}}>you have no account <Link to="signup">register</Link></Form.Text>
        </Form>
    </div>
    <div style={{width: 500,marginTop: 100,float: 'left'}}>
        <img src={banner} style={{width: 550}}/>
    </div>
    {/* <AlertCustom status={status}/> */}
    </div>
  )
}
