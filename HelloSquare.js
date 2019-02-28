import React, {Component} from 'react';
import {requireNativeComponent} from 'react-native';


const HelloWorldSquare = requireNativeComponent("SimpleSquareView",HelloSquare)
export default class HelloSquare extends Component {
  render() {
    return (
     <HelloWorldSquare {...this.props} />
    );
  }
}

