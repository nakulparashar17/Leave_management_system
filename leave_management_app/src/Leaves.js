import React, { Component } from 'react';
import AppNav from './AppNav';

class Leaves extends Component {
    state = {
        isLoading: true,
        LeavesArray: []

    }
    async componentDidMount() {
        const response = await fetch("/leaves")
        const body = await response.json();
        this.setState({ LeavesArray: body, isLoading: false });
    }
    render() {
        const { LeavesArray, isLoading } = this.state;
        if (isLoading)
            return ( < div > Loading... < /div>)

                return ( <
                    div >
                    <
                    AppNav > < /AppNav> <
                    h2 > LeavesArray < /h2> {
                        LeavesArray.map(leaves =>
                            <
                            div id = { leaves.id } > { leaves.type } { leaves.reason } { leaves.fromDate } { leaves.toDate } { leaves.duration } <
                            /div>   
                        )
                    } <
                    /div>
                );
            }
    }

    export default Leaves;