import React, { Component } from 'react';
import { Nav, NavItem, NavLink, NavbarBrand, Navbar } from 'reactstrap';

class AppNav extends Component {
    state = {}
    render() {
        return ( <
            div >
            <
            Navbar color = "dark"
            dark expand = "md" >
            <
            NavbarBrand href = "/" > Leaves Management App < /NavbarBrand> <
            Nav className = "mr-auto"
            navbar >
            <
            NavItem >
            <
            NavLink href = "/home/" > Home < /NavLink> <
            /NavItem> <
            NavItem >
            <
            NavLink href = "/employees" > Employess < /NavLink> <
            /NavItem> <
            NavItem >
            <
            NavLink href = "/leaves" > Leaves < /NavLink> <
            /NavItem> <
            NavItem >
            <
            NavLink href = "/employees" > Add Employess < /NavLink> <
            /NavItem> <
            /Nav> <
            /Navbar> <
            /div>
        );
    }
}

export default AppNav;