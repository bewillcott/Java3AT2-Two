/*
 *  File Name:    MechanicalPart.java
 *  Project Name: Common
 *
 *  Copyright (c) 2021 Bradley Willcott
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * ****************************************************************
 * Name: Bradley Willcott
 * ID:   M198449
 * Date: 28 Aug 2021
 * ****************************************************************
 */
package com.bewsoftware.tafe.java3.at2.two.common;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Objects;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * Stores information about a single part.
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 *
 * @since 1.0
 * @version 1.0
 */
public class MechanicalPart implements Serializable, Comparable<MechanicalPart>
{

    private static final String PROP_COST = "cost";
    private static final String PROP_DESCRIPTION = "description";
    private static final String PROP_MARKUP = "markup";
    private static final String PROP_QUANTITY = "quantity";

    /**
     * For serialization.
     */
    private static final long serialVersionUID = -6909187360407793176L;

    /**
     * The purchase cost of the part.
     */
    private double cost;

    /**
     * The detailed description of the part.
     */
    private String description;

    /**
     * The retail markup percentage.
     */
    private double markup;

    /**
     * Name of the part.
     * <p>
     * This is the part 'id', therefore it is read-only. Further, it <b>must</b> be unique.
     * This is the field that the parts are sorted on.
     */
    private final String name;

    /**
     * Property change support.
     */
    private final transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * The current quantity in stock.
     */
    private int quantity;

    /**
     * Instantiate a MechanicalPart object.
     *
     * @param name the name of the part - MUST be unique
     */
    public MechanicalPart(String name)
    {
        this.name = name;
    }

    /**
     * Instantiate a MechanicalPart object.
     *
     * @param name        the name of the part - MUST be unique
     * @param description the detailed description of the part
     * @param quantity    the current quantity in stock
     * @param cost        the purchase cost of the part
     * @param markup      the retail markup percentage
     */
    public MechanicalPart(String name, String description, String quantity, String cost, String markup)
    {
        this(name);
        this.cost = parseDouble(cost);
        this.description = description;
        this.markup = parseDouble(markup);
        this.quantity = parseInt(quantity);
    }

    @Override
    public int compareTo(MechanicalPart o)
    {
        return !this.equals(Objects.requireNonNull(o)) ? this.name.compareTo(o.name) : 0;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null)
        {
            return false;
        }

        if (getClass() != obj.getClass())
        {
            return false;
        }

        final MechanicalPart other = (MechanicalPart) obj;
        return Objects.equals(this.name, other.name);
    }

    /**
     * The purchase cost of the part.
     *
     * @return the cost
     */
    public double getCost()
    {
        return cost;
    }

    /**
     * The purchase cost of the part.
     *
     * @param cost the cost to set
     */
    public void setCost(double cost)
    {
        double oldCost = this.cost;
        this.cost = cost;
        propertyChangeSupport.firePropertyChange(PROP_COST, oldCost, cost);
    }

    /**
     * The detailed description of the part.
     *
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * The detailed description of the part.
     *
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        java.lang.String oldDescription = this.description;
        this.description = description;
        propertyChangeSupport.firePropertyChange(PROP_DESCRIPTION, oldDescription, description);
    }

    /**
     * The retail markup percentage.
     *
     * @return the markup
     */
    public double getMarkup()
    {
        return markup;
    }

    /**
     * The retail markup percentage.
     *
     * @param markup the markup to set
     */
    public void setMarkup(double markup)
    {
        double oldMarkup = this.markup;
        this.markup = markup;
        propertyChangeSupport.firePropertyChange(PROP_MARKUP, oldMarkup, markup);
    }

    /**
     * Name of the part.
     * <p>
     * This is the 'id', therefore it is read-only. Further, it <b>must</b> be unique. This is the
     * field that is sorted on.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * The current quantity in stock.
     *
     * @return the quantity
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * The current quantity in stock.
     *
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity)
    {
        int oldQuantity = this.quantity;
        this.quantity = quantity;
        propertyChangeSupport.firePropertyChange(PROP_QUANTITY, oldQuantity, quantity);
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    /**
     * The retail price of this part.
     *
     * @return the price
     */
    public double retailPrice()
    {
        return cost + (cost * markup / 100);
    }

    @Override
    public String toString()
    {
        return "MechanicalPart{\n"
               + "  name = " + name + ",\n"
               + "  description = " + description + ",\n"
               + "  quantity = " + quantity + ",\n"
               + "  cost = " + cost + ",\n"
               + "  markup = " + markup + "\n"
               + "}";
    }

    /**
     * The current value of the stock on-hand of this part.
     *
     * @return dollar and cents value
     */
    public double totalValue()
    {
        return quantity * cost;
    }

}
