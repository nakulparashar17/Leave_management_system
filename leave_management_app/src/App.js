import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Leaves from './Leaves';
import Home from './Home';
import Employee from './Employee';

class App extends Component {
    state = {}
    render() {
        return ( <
            Router >
            <
            Switch >
            <
            Route path = '/'
            exact = { true }
            Component = { Home }
            /> <
            Route path = '/leave'
            exact = { true }
            Component = { Leaves }
            /> <
            Route path = '/employee'
            exact = { true }
            Component = { Employee }
            /> <
            /Switch> <
            /Router>

        );
    }
}

export default App;