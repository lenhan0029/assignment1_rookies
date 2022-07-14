
import React, { Component,useEffect,useState } from 'react'
import { Container,Navbar,Nav,NavDropdown} from 'react-bootstrap';
import { Link } from 'react-router-dom';
import {  MDBIcon } from 'mdb-react-ui-kit';
import { useDispatch,useSelector } from 'react-redux';
import { selectUser } from '../saga/user/userSlice';

export const User = (props) => {
  let styledropdown = {
    fontSize: 17,
    margin:15
  }
  const handleClick = () => {
    // localStorage.removeItem("token");
    // localStorage.removeItem("user");
    // window.location.assign("http://localhost:3000/product");
  }
  if(props.id > 0){
    return (
    <> 
    <Link to="userinfo" style={{
                  textDecoration: 'none',
                  color: 'white',
                  fontSize: 18,
                  margin: 20,
                  marginLeft: 50
                }}> HI, {props.username}</Link>
    <NavDropdown title="More" id="collasible-nav-dropdown" style={styledropdown}>
              <NavDropdown.Item ><Link to="userinfo" style={{
                  textDecoration: 'none',
                  color: 'black',
                }}>information</Link>
              </NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item onClick={() => {
                // localStorage.removeItem("token");
                // localStorage.removeItem("user");
                window.localStorage.clear();
                window.location.assign("http://localhost:3000/product");
              }}>Log out</NavDropdown.Item>
            </NavDropdown>
    {/* <MDBIcon className='yellow-text pr-3' size='2x' icon="user" />{props.username} */}
    </>)
  }
  return <Link to="login" style={{
    textDecoration: 'none',
    color: 'white',
    fontSize: 18,
    margin: 20,
    marginLeft: 50
  }}><MDBIcon className='yellow-text pr-3' size='2x' icon="user" /></Link>
}
export default function Navbars() {

  const [user,setUser] = useState({id: 0,username: ''});
  useEffect(() => {
     const result = JSON.parse(localStorage.getItem("user"));
     if(result != null){
      setUser(result);
     }
  },[])
  console.log(user);
  let stylelink = {
    textDecoration: 'none',
    color: 'white',
    fontSize: 18,
    margin: 20,
    marginLeft: 50
  }
  let styledropdown = {
    fontSize: 17,
    margin:15
  }
 
  return (
    <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark" sticky="top">
      <Container>
        <Navbar.Brand href="/">NhanStore</Navbar.Brand>
        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav className="me-auto">
            {/* <Nav.Link href="product">Product</Nav.Link> */}
            <Link to="product" style={stylelink}>product</Link>
            {/* <NavDropdown title="Dropdown" id="collasible-nav-dropdown" style={styledropdown}>
              <NavDropdown.Item ><Link to="brand">brand</Link></NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="/product">all</NavDropdown.Item>
            </NavDropdown> */}
            <Link to="order" style={stylelink}>orders</Link>
          </Nav>
          <Nav>
            <Link to="cart" style={stylelink}><MDBIcon className='yellow-text pr-3' size='2x' icon="shopping-cart" /></Link>
            {/* <Link to="login" style={stylelink}><MDBIcon className='yellow-text pr-3' size='2x' icon="user" /></Link> */}
            <User id={user.id} username={user.username} />
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  )
}
