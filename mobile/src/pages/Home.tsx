import React from 'react';
import { IonContent, IonPage, IonIcon, IonButton } from '@ionic/react';
import { arrowForward } from 'ionicons/icons';
import NBA from '../../public/nba.png';
import { useHistory } from 'react-router-dom';
import { useState,useEffect } from 'react';
import axios from 'axios';
import './Home.css';

const Home: React.FC = () => {
  const history = useHistory();
  const [form, setForm] = useState([]);

  const teams = [
    { name: 'Équipe A', imageUrl: '../../public/golden-state-warriors-logo.png', id: 1 },
    { name: 'Équipe B', imageUrl: '../../public/golden-state-warriors-logo.png', id: 2 },
    { name: 'Équipe C', imageUrl: '../../public/golden-state-warriors-logo.png', id: 3 },
    { name: 'Équipe D', imageUrl: '../../public/golden-state-warriors-logo.png', id: 4 },
    { name: 'Équipe E', imageUrl: '../../public/golden-state-warriors-logo.png', id: 5 },
  ];

  const handleIconClick = (teamId: number) => {
    history.push(`/stats/${teamId}`);
  };

  useEffect(() => {
    axios.get('https://api.example.com/teams')
      .then(response => {
        setForm(response.data);
      })
      .catch(error => {
        console.error('Erreur lors de la requête', error);
      });
  }, []);
  

  return (
    <IonPage>
      <IonContent className='ion-content'>
        <section className='body'>
          <div className='logo'>
            <img src={NBA} alt="" />
          </div>

          <div className="list-teams">
            {teams.map((team, index) => (
              <div className="team" key={index}>
                <img src={team.imageUrl} alt="" />
                <h4>{team.name}</h4>
                <button onClick={() => handleIconClick(team.id)}>
                  <IonIcon icon={arrowForward} className='arrowForward'/>
                </button>
              </div>
            ))}
          </div>
        </section>
      </IonContent>
    </IonPage>
  );
};

export default Home;