import React from 'react';
import { IonContent, IonPage,IonGrid, IonRow, IonCol } from '@ionic/react';
import NBA from '../../public/nba.png';
import './Stats.css';

const Stats: React.FC = () => {

    return (
      <IonPage>
      <IonContent className='ion-content'>
        <section className='body'>
          <div className='logo'>
            <img src={NBA} alt="" />
          </div>

          <div className="list-teams">
              <IonGrid>
              {/* Row 1 */}
              <h4>Point par match</h4>
              <IonRow>
                <IonCol>Cell 1</IonCol>
                <IonCol>Cell 2</IonCol>
                <IonCol>Cell 3</IonCol>
              </IonRow>
        
              {/* Row 2 */}
              <h4>Rebond par match</h4>
              <IonRow>
                <IonCol>Cell 4</IonCol>
                <IonCol>Cell 5</IonCol>
                <IonCol>Cell 6</IonCol>
              </IonRow>

              <h4>Passe decisive par match</h4>
              <IonRow>
                <IonCol>Cell 4</IonCol>
                <IonCol>Cell 5</IonCol>
                <IonCol>Cell 6</IonCol>
              </IonRow>

              <h4>Pourcentage Tir par match</h4>
              <IonRow>
                <IonCol>Cell 4</IonCol>
                <IonCol>Cell 5</IonCol>
                <IonCol>Cell 6</IonCol>
              </IonRow>

              <h4>Pourcentage 3-pt par match</h4>
              <IonRow>
                <IonCol>Cell 4</IonCol>
                <IonCol>Cell 5</IonCol>
                <IonCol>Cell 6</IonCol>
              </IonRow>

              <h4>Pourcentage Lancé par match</h4>
              <IonRow>
                <IonCol>Cell 4</IonCol>
                <IonCol>Cell 5</IonCol>
                <IonCol>Cell 6</IonCol>
              </IonRow>

              <h4>Pourcentage Lancé par match</h4>
              <IonRow>
                <IonCol>Cell 4</IonCol>
                <IonCol>Cell 5</IonCol>
                <IonCol>Cell 6</IonCol>
              </IonRow>

              <h4>Pourcentage Lancé par match</h4>
              <IonRow>
                <IonCol>Cell 4</IonCol>
                <IonCol>Cell 5</IonCol>
                <IonCol>Cell 6</IonCol>
              </IonRow>

              <h4>Pourcentage Lancé par match</h4>
              <IonRow>
                <IonCol>Cell 11</IonCol>
                <IonCol>Cell 12</IonCol>
                <IonCol>Cell 13</IonCol>
              </IonRow>
        
            </IonGrid>
          </div>
        </section>
      </IonContent>
    </IonPage>
      );
};

export default Stats;