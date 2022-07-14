import React from 'react'
import Nav from 'react-bootstrap/Nav';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Button from 'react-bootstrap/Button'
import Form from 'react-bootstrap/Form'

function ProductNav() {
    let styleproductnav = {
        marginTop: 20,
        marginLeft: 70,
        marginBottom: 100
    }
    let styleform = {
        marginLeft: 200,
    }
    const handleSelect = (eventKey) => alert(`selected ${eventKey}`);
  return (
    <Nav variant="pills" activeKey="1" onSelect={handleSelect} style={styleproductnav}>
      <NavDropdown title="Brand" id="nav-dropdown1">
        <NavDropdown.Item eventKey="4.1">Action</NavDropdown.Item>
        <NavDropdown.Item eventKey="4.2">Another action</NavDropdown.Item>
        <NavDropdown.Item eventKey="4.3">Something else here</NavDropdown.Item>
        <NavDropdown.Divider />
        <NavDropdown.Item eventKey="4.4">Separated link</NavDropdown.Item>
      </NavDropdown>
      <NavDropdown title="Category" id="nav-dropdown">
        <NavDropdown.Item eventKey="4.1">Action</NavDropdown.Item>
        <NavDropdown.Item eventKey="4.2">Another action</NavDropdown.Item>
        <NavDropdown.Item eventKey="4.3">Something else here</NavDropdown.Item>
        <NavDropdown.Divider />
        <NavDropdown.Item eventKey="4.4">Separated link</NavDropdown.Item>
      </NavDropdown>
      <Form className="d-flex" style={styleform}>
            <Form.Control
              type="search"
              placeholder="Search"
              className="me-2"
              aria-label="Search"
            />
            <Button variant="outline-success">Search</Button>
        </Form>

    </Nav>
  )
}

export default ProductNav