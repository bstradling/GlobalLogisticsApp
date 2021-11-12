package com.example.globallogisticsapp;

public class ShippingManifest {
    private String ShippingType;
    private String Vessel;
    private String VoyageNumber;
    private String Truck;
    private String GrossWeight;
    private String LicenceID;
    private String Departure;
    private String Arrival;
    private String Reception;
    private String Delivery;
    private String BillNumber;
    private String SailingDate;
    private String DepartureDate;
    private String ArrivalDate;
    private String ShipperName;
    private String ShipperAddress;
    private String ShipperAccount;
    private String ConsigneeName;
    private String ConsigneeAddress;
    private String ConsigneeAccount;
    private String NotifyParty;
    private String Carrier;
    private String CarrierAgentName;
    private String CarrierAgentAddress;
    private String IataCode;
    private String ContainerNumber;
    private String AccountNumber;
    private String Description;
    private String Quality;
    private String NumberofPieces;
    private String Packaging;
    private String ContainerType;
    private String Dimensions;
    private String Weight;
    private String Units;
    private String Volume;
    private String AccountInfo;
    private String Reference;
    //Add the fields from the additional services page.

    //Consider adding the additional services fields here as well to already be part of the JSON
    //data. And consider changing the name from ShippingManifest to InvoiceData or something
    //that encompasses the manifest and additional services fields.

    public ShippingManifest(){
        //Default Construct
    }

    //Setter functions

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public void setAccountInfo(String accountInfo) {
        AccountInfo = accountInfo;
    }

    public void setArrival(String arrival) {
        Arrival = arrival;
    }

    public void setArrivalDate(String arrivalDate) {
        ArrivalDate = arrivalDate;
    }

    public void setBillNumber(String billNumber) {
        BillNumber = billNumber;
    }

    public void setCarrier(String carrier) {
        Carrier = carrier;
    }

    public void setCarrierAgentAddress(String carrierAgentAddress) {
        CarrierAgentAddress = carrierAgentAddress;
    }

    public void setCarrierAgentName(String carrierAgentName) {
        CarrierAgentName = carrierAgentName;
    }

    public void setConsigneeAccount(String consigneeAccount) {
        ConsigneeAccount = consigneeAccount;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        ConsigneeAddress = consigneeAddress;
    }

    public void setConsigneeName(String consigneeName) {
        ConsigneeName = consigneeName;
    }

    public void setContainerNumber(String containerNumber) {
        ContainerNumber = containerNumber;
    }

    public void setContainerType(String containerType) {
        ContainerType = containerType;
    }

    public void setDelivery(String delivery) {
        Delivery = delivery;
    }

    public void setDeparture(String departure) {
        Departure = departure;
    }

    public void setDepartureDate(String departureDate) {
        DepartureDate = departureDate;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setDimensions(String dimensions) {
        Dimensions = dimensions;
    }

    public void setGrossWeight(String grossWeight) {
        GrossWeight = grossWeight;
    }

    public void setIataCode(String iataCode) {
        IataCode = iataCode;
    }

    public void setLicenceID(String licenceID) {
        LicenceID = licenceID;
    }

    public void setNotifyParty(String notifyParty) {
        NotifyParty = notifyParty;
    }

    public void setNumberofPieces(String numberofPieces) {
        NumberofPieces = numberofPieces;
    }

    public void setPackaging(String packaging) {
        Packaging = packaging;
    }

    public void setQuality(String quality) {
        Quality = quality;
    }

    public void setReception(String reception) {
        Reception = reception;
    }

    public void setReference(String reference) {
        Reference = reference;
    }

    public void setSailingDate(String sailingDate) {
        SailingDate = sailingDate;
    }

    public void setShipperAccount(String shipperAccount) {
        ShipperAccount = shipperAccount;
    }

    public void setShipperAddress(String shipperAddress) {
        ShipperAddress = shipperAddress;
    }

    public void setShipperName(String shipperName) {
        ShipperName = shipperName;
    }

    public void setShippingType(String shippingType) {
        ShippingType = shippingType;
    }

    public void setTruck(String truck) {
        Truck = truck;
    }

    public void setUnits(String units) {
        Units = units;
    }

    public void setVessel(String vessel) {
        Vessel = vessel;
    }

    public void setVolume(String volume) {
        Volume = volume;
    }

    public void setVoyageNumber(String voyageNumber) {
        VoyageNumber = voyageNumber;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    //Create a new Shipping manifest object in the Activity and set the values from the activity
    //make a new variable String json = gson.json(object);

}
