import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// Définition des interfaces pour les événements, pour plus de sécurité de type
export interface Address {
  name: string;
  city: string;
  zipCode: string;
  streetName: string;
  streetNumber: string;
}

export interface Event {
  id: string;
  name: string;
  description: string;
  address: Address;
  participants: string[];
  organizers: string[];
  date: string;
  time: string;
  themes: string[];
}

export interface NewEvent {
  name: string;
  description: string;
  address: Address;
  organizers: string[];
  date: string;
  time: string;
  themes: string[];
}

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private apiUrl = 'http://localhost:3000/events';

  constructor(private http: HttpClient) {}

  // Récupérer tous les événements
  getAllEvents(): Observable<Event[]> {
    return this.http.get<Event[]>(this.apiUrl);
  }

  // Récupérer un événement par son ID
  getEventById(eventId: string): Observable<Event> {
    return this.http.get<Event>(`${this.apiUrl}/${eventId}`);
  }

  // Créer un nouvel événement
  createEvent(event: NewEvent): Observable<Event> {
    return this.http.post<Event>(this.apiUrl, event);
  }

  // Mettre à jour un événement
  updateEvent(eventId: string, event: NewEvent): Observable<Event> {
    return this.http.put<Event>(`${this.apiUrl}/${eventId}`, event);
  }

  // Supprimer un événement
  deleteEvent(eventId: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${eventId}`);
  }

  // Ajouter un participant à un événement
  addParticipant(eventId: string, userId: number): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/${eventId}/participants`, { userId });
  }

  // Supprimer un participant d'un événement
  deleteParticipant(eventId: string, userId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${eventId}/participants/${userId}`);
  }

  // Ajouter un organisateur à un événement
  addOrganizer(eventId: string, userId: number): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/${eventId}/organizers`, { userId });
  }

  // Supprimer un organisateur d'un événement
  deleteOrganizer(eventId: string, userId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${eventId}/organizers/${userId}`);
  }
}
