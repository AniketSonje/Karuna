
import React from 'react';
import Button from 'react-bootstrap/Button';
import { Link, useNavigate } from "react-router-dom";
import { toast } from 'react-toastify';
import DonorService from '../../services/DonorService';
import DonorDashboard from "./DonorDashboard";
import './DonorProfile.css';



const DonorProfile = () => {
  
  
  const navigator=useNavigate()


  const don = JSON.parse(localStorage.getItem("user")).data

  console.log(don)

  const logout = () => {
    localStorage.removeItem("user");
    sessionStorage.removeItem("user");
    navigator("/home")

  }

  const deleteDonor=(event)=>{
    event.preventDefault()
    DonorService.deleteDonor(don.id).then((response)=>{
      toast.success(response.data)
      logout()
     
     

    }).catch((error)=>{
      console.log(error)
      toast.error(error)
    })
  }

  return (
    <div>
      <div className="container">
        <div>
          <DonorDashboard></DonorDashboard>
        </div>
        <div className="content">

            
            <div className="profile-container">
                <div className="profile-details">
                    <h2>{don.name}</h2>
                    <p>{don.phone}</p>
                    <p>{don.address}</p>
                    <p>{don.email}</p>
                    <p>Donation Count {don.donationCount}</p>
                    <Link to={"/donorupdate"}><Button variant="outline-danger">Update </Button></Link>
                    <Button variant="outline-danger" onClick={deleteDonor}>Delete Account </Button>
                </div>
            </div>

            
        </div>
    </div>

        
    </div>


   
  );
};

export default DonorProfile;
