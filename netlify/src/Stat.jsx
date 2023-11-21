import './assets/bootstrap/css/bootstrap.min.css';
import './assets/css/style.css';
import './assets/css/style2.css';

function Stat() {
    return (
        <div className="Stat">
            <header>
                <h2>Statistiques individuelles</h2>
                <h4>Saison 2023-2024</h4>
            </header>

            <div class="container">
                <div class="main">

                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-responsive custom-table-responsive">
                                <table class="table custom-table">
                                    <thead>
                                        <tr>
                                            <th scope="col">CLASSEMENT</th>
                                            <th scope="col">JOUEUR</th>
                                            <th scope="col">ÉQUIPE</th>
                                            <th scope="col">M</th>
                                            <th scope="col">MJ</th>
                                            <th scope="col">PPM</th>
                                            <th scope="col">RPM</th>
                                            <th scope="col">PDPM</th>
                                            <th scope="col">FG%</th>
                                            <th scope="col">3P%</th>
                                            <th scope="col">%LF</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr scope="row">
                                            <td>1</td>
                                            <td>LeBron James</td>
                                            <td>Los Angeles Lakers</td>
                                            <td>75</td>
                                            <td>35</td>
                                            <td>28.5</td>
                                            <td>7.2</td>
                                            <td>6.3</td>
                                            <td>50.2%</td>
                                            <td>36.7%</td>
                                            <td>77.8%</td>
                                        </tr>

                                        <tr class="spacer">
                                            <td colspan="100"></td>
                                        </tr>

                                        <tr>
                                            <td>2</td>
                                            <td>Kevin Durant</td>
                                            <td>Brooklyn Nets</td>
                                            <td>68</td>
                                            <td>32</td>
                                            <td>25.8</td>
                                            <td>5.5</td>
                                            <td>4.1</td>
                                            <td>52.3%</td>
                                            <td>40.2%</td>
                                            <td>88.1%</td>
                                        </tr>

                                        <tr class="spacer">
                                            <td colspan="100"></td>
                                        </tr>

                                        <tr>
                                            <td>3</td>
                                            <td>Giannis Antetokounmpo</td>
                                            <td>Milwaukee Bucks</td>
                                            <td>72</td>
                                            <td>34</td>
                                            <td>29.9</td>
                                            <td>10.3</td>
                                            <td>5.8</td>
                                            <td>55.6%</td>
                                            <td>30.3%</td>
                                            <td>69.7%</td>
                                        </tr>

                                        <tr class="spacer">
                                            <td colspan="100"></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>


                        </div>
                    </div>
                </div>

            </div>
            <footer>NBA</footer>
        </div>
    );
}

export default Stat;