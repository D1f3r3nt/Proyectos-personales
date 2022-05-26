import './App.css';
import ListaTareas from './Complementos/ListaTareas';
import FormTareas from './Complementos/FormTareas';
import { BrowserRouter, Route,  Switch, Link } from 'react-router-dom';

function App() {
    return (
        <BrowserRouter>
            <div className='App'>
                <nav class="navbar navbar-light ">
                    <form class="container-fluid justify-content-center">
                        <Link to="/"><button class="btn btn-outline-success me-2" type="button">Lista</button></Link>
                        <Link to="/create"><button class="btn btn-outline-success me-2" type="button">New</button></Link>
                    </form>
                </nav>
                <div className='content'>
                    <Switch>
                        <Route exact path='/'>
                            <ListaTareas/>
                        </Route>
                        <Route exact path='/create'>
                            <FormTareas/>
                        </Route>
                    </Switch> 
                </div>
            </div>
        </BrowserRouter>
    );
}

export default App;
