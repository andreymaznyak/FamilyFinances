<?php

namespace Ibw\FamilyFinancesBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * UserIncome
 */
class UserIncome
{
    /**
     * @var integer
     */
    private $id;

    /**
     * @var integer
     */
    private $cost;

    /**
     * @var string
     */
    private $description;

    /**
     * @var boolean
     */
    private $is_active;

    /**
     * @var \DateTime
     */
    private $created_at;

    /**
     * @var \DateTime
     */
    private $updated_at;

    /**
     * @var \Ibw\FamilyFinancesBundle\Entity\User
     */
    private $user;

    /**
     * @var \Ibw\FamilyFinancesBundle\Entity\Fund
     */
    private $fund;

    /**
     * @var \Ibw\FamilyFinancesBundle\Entity\Income
     */
    private $income;
	
	private $pieinfo;

    /**
     * Get id
     *
     * @return integer 
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set cost
     *
     * @param integer $cost
     * @return UserIncome
     */
    public function setCost($cost)
    {
        $this->cost = $cost;

        return $this;
    }

    /**
     * Get cost
     *
     * @return integer 
     */
    public function getCost()
    {
        return $this->cost;
    }

    /**
     * Set description
     *
     * @param string $description
     * @return UserIncome
     */
    public function setDescription($description)
    {
        $this->description = $description;

        return $this;
    }

    /**
     * Get description
     *
     * @return string 
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * Set is_active
     *
     * @param boolean $isActive
     * @return UserIncome
     */
    public function setIsActive($isActive)
    {
        $this->is_active = $isActive;

        return $this;
    }

    /**
     * Get is_active
     *
     * @return boolean 
     */
    public function getIsActive()
    {
        return $this->is_active;
    }

    /**
     * Set created_at
     *
     * @param \DateTime $createdAt
     * @return UserIncome
     */
    public function setCreatedAt($createdAt)
    {
        $this->created_at = $createdAt;

        return $this;
    }

    /**
     * Get created_at
     *
     * @return \DateTime 
     */
    public function getCreatedAt()
    {
        return $this->created_at;
    }

    /**
     * Set updated_at
     *
     * @param \DateTime $updatedAt
     * @return UserIncome
     */
    public function setUpdatedAt($updatedAt)
    {
        $this->updated_at = $updatedAt;

        return $this;
    }

    /**
     * Get updated_at
     *
     * @return \DateTime 
     */
    public function getUpdatedAt()
    {
        return $this->updated_at;
    }

    /**
     * Set user
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\User $user
     * @return UserIncome
     */
    public function setUser(\Ibw\FamilyFinancesBundle\Entity\User $user = null)
    {
        $this->user = $user;

        return $this;
    }

    /**
     * Get user
     *
     * @return \Ibw\FamilyFinancesBundle\Entity\User 
     */
    public function getUser()
    {
        return $this->user;
    }

    /**
     * Set fund
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\Fund $fund
     * @return UserIncome
     */
    public function setFund(\Ibw\FamilyFinancesBundle\Entity\Fund $fund = null)
    {
        $this->fund = $fund;

        return $this;
    }

    /**
     * Get fund
     *
     * @return \Ibw\FamilyFinancesBundle\Entity\Fund 
     */
    public function getFund()
    {
        return $this->fund;
    }

    /**
     * Set income
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\Income $income
     * @return UserIncome
     */
    public function setIncome(\Ibw\FamilyFinancesBundle\Entity\Income $income = null)
    {
        $this->income = $income;

        return $this;
    }

    /**
     * Get income
     *
     * @return \Ibw\FamilyFinancesBundle\Entity\Income 
     */
    public function getIncome()
    {
        return $this->income;
    }
    /**
     * @ORM\PrePersist
     */
    public function setCreatedAtValue()
    {
        // Add your code here
		if(!$this->getCreatedAt()) {
            $this->created_at = new \DateTime();
        }
    }

    /**
     * @ORM\PreUpdate
     */
    public function setUpdatedAtValue()
    {
        // Add your code here
		$this->updated_at = new \DateTime();
    }
}
