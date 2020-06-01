import React, { Component } from 'react';
import AppNav from './AppNav';

class Employee extends Component {
    state = {
        isLoading: true,
        EmployeesArray: []
    }
    async componentDidMount() {
        const response = await fetch("/employees")
        const body = await response.json();
        this.setState({ EmployeesArray: body, isLoading: false });
    }
    render() {
        const { EmployeesArray, isLoading } = this.state;
        if (isLoading)
            return ( < div > Loading... < /div>)

                return ( <
                    div >
                    <
                    AppNav > < /AppNav> <
                    h2 > EmployeesArray < /h2> {
                        EmployeesArray.map(employees =>
                            <
                            div id = { employees.id } > { employees.empName } { employees.empEmailId } { employees.empLeaveEarned } <
                            /div>   
                        )
                    } <
                    /div>
                );
            }
    }

    export default Employee;