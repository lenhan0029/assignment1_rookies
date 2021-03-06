import React from 'react';
import { Carousel} from 'react-bootstrap';
function Banner() {
  return (
    <Carousel>
        <Carousel.Item interval={3000}>
            <img
            className="d-block w-100"
            src={process.env.PUBLIC_URL+"assets/banner1.png"}
            alt="First slide"
            />
            <Carousel.Caption>
            <h3>First slide label</h3>
            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
            </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item interval={3000}>
            <img
            className="d-block w-100"
            src={process.env.PUBLIC_URL+"assets/banner2.png"}
            alt="Second slide"
            />
            <Carousel.Caption>
            <h3>Second slide label</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item interval={3000}>
            <img
            className="d-block w-100"
            src={process.env.PUBLIC_URL+"assets/banner3.png"}
            alt="Third slide"
            />
            <Carousel.Caption>
            <h3>Third slide label</h3>
            <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
            </Carousel.Caption>
        </Carousel.Item>
    </Carousel>
  )
}

export default Banner