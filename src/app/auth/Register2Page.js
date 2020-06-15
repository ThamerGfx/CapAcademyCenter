import React, {Component} from 'react';
import {Button, Card, CardContent, Checkbox, FormControl, FormControlLabel, TextField, Typography} from '@material-ui/core';
import {FuseAnimate} from '@fuse';
import {Link} from 'react-router-dom';
import _ from '@lodash';
import {registerUser} from './store/actions/register.actions';
import { connect } from 'react-redux';
import logo from './logo.png'

var today = new Date();
var dd = today.getDate();

var mm = today.getMonth()+1; 
var yyyy = today.getFullYear();
today = dd+'-'+mm+'-'+yyyy;

class Register2Page extends Component {

    state = {
        nom                  : '',
        prenom               : '',
        email                : '',
        num_telephone        : '',
        password             : '',
        passwordConfirm      : '',
        date1                : today
    };

    // handleChange = (event) => {
    //     this.setState(_.set({...this.state}, event.target.name, event.target.type === 'checkbox' ? event.target.checked : event.target.value));
    // };
    handleChange = (e) => {
        this.setState({
          [e.target.id]: e.target.value
        })
    }

    handleSubmit = (e) => {
        e.preventDefault();
        this.props.registerUser( this.state );
        this.setState(
            {
                nom                  : '',
                prenom               : '',
                email                : '',
                num_telephone        : '',
                password             : '',
                passwordConfirm      : '',
                date1                : today
            }
        )
    }

    render() 
    {
        return (
            <div className="flex flex-col flex-auto flex-no-shrink p-24 md:flex-row md:p-0">

                <div
                    className="flex flex-col flex-no-grow items-center text-white p-16 text-center md:p-128 md:items-start md:flex-no-shrink md:flex-1 md:text-left">

                    <FuseAnimate animation="transition.expandIn">
                        <img className="w-128 mb-32" src={logo}/>
                    </FuseAnimate>

                    <FuseAnimate animation="transition.slideUpIn" delay={300}>
                        <Typography variant="h3" color="primary" className="font-dark">
                            Bienvenue au CapAcademy
                        </Typography>
                    </FuseAnimate>
                </div>

                <FuseAnimate animation={{translateX: [0, '100%']}}>

                    <Card className="w-full max-w-400 mx-auto m-16 md:m-0" square>

                        <CardContent className="flex flex-col items-center justify-center p-32 md:p-48 md:pt-128 ">

                            <Typography variant="h6" className="md:w-full mb-32">CREATE AN ACCOUNT</Typography>

                            <form name="registerForm" noValidate className="flex flex-col justify-center w-full">

                                <TextField
                                    className="mb-16"
                                    label="Nom"
                                    autoFocus
                                    id="nom"
                                    type="nom"
                                    name="nom"
                                    value={this.state.nom}
                                    onChange={this.handleChange}
                                    variant="outlined"
                                    required
                                    fullWidth
                                />
                                <TextField
                                    className="mb-16"
                                    label="Prénom"
                                    autoFocus
                                    id="prenom"
                                    type="prenom"
                                    name="prenom"
                                    value={this.state.prenom}
                                    onChange={this.handleChange}
                                    variant="outlined"
                                    required
                                    fullWidth
                                />
                                <TextField
                                    className="mb-16"
                                    label="Email"
                                    id="email"
                                    type="email"
                                    name="email"
                                    value={this.state.email}
                                    onChange={this.handleChange}
                                    variant="outlined"
                                    required
                                    fullWidth
                                />
                                <TextField
                                    className="mb-16"
                                    label="Téléphone"
                                    id="num_telephone"
                                    type="num_telephone"
                                    name="num_telephone"
                                    value={this.state.num_telephone}
                                    onChange={this.handleChange}
                                    variant="outlined"
                                    required
                                    fullWidth
                                />
                                <TextField
                                    className="mb-16"
                                    label="Password"
                                    id="password"
                                    type="password"
                                    name="password"
                                    value={this.state.password}
                                    onChange={this.handleChange}
                                    variant="outlined"
                                    required
                                    fullWidth
                                />

                                <TextField
                                    className="mb-16"
                                    label="Password (Confirm)"
                                    id="passwordConfirm"
                                    type="password"
                                    name="passwordConfirm"
                                    value={this.state.passwordConfirm}
                                    onChange={this.handleChange}
                                    variant="outlined"
                                    required
                                    fullWidth
                                />
                                <Button 
                                    variant="contained" 
                                    color="primary" 
                                    className="w-full mx-auto mt-16" 
                                    aria-label="Register"
                                    onClick = { this.handleSubmit }
                                >
                                    CREATE AN ACCOUNT
                                </Button>

                            </form>

                            <div className="flex flex-col items-center justify-center pt-32 pb-24">
                                <span className="font-medium">Already have an account?</span>
                                <Link className="font-medium" to="/Login">Login</Link>
                            </div>

                        </CardContent>
                    </Card>
                </FuseAnimate>
            </div>
        );
    }
}
const mapStateToProps = (state) => {
    return {
        // userItem: state.register.userItem
    }
}
  
export default connect( mapStateToProps, {registerUser} )( Register2Page )